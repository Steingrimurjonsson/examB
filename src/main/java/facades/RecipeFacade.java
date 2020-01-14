package facades;

import dto.Item_dto;
import dto.Menu_dto;
import dto.Recipe_dto;
import dto.Storage_dto;
import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.Storage;
import entities.WeekMenuPlan;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * @author stein
 */
public class RecipeFacade {

    private static EntityManagerFactory emf;
    private static RecipeFacade instance;

    private RecipeFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static RecipeFacade getRecipeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Item_dto> getItems() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            List<Item> items = em.createNamedQuery("Item.all").getResultList();
            em.getTransaction().commit();
            List<Item_dto> itemsDTO = new ArrayList();
            items.forEach((item) -> {
                itemsDTO.add(new Item_dto(item));
            });
            return itemsDTO;
        } finally {
            em.close();
        }
    }

    public List<Storage_dto> getStorage() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            List<Storage> storages = em.createNamedQuery("Storage.all").getResultList();
            em.getTransaction().commit();
            List<Storage_dto> storagesDTO = new ArrayList();
            storages.forEach((storage) -> {
                storagesDTO.add(new Storage_dto(storage));
            });
            return storagesDTO;
        } finally {
            em.close();
        }
    }

    public Storage_dto addToStorage(Storage_dto storage_dto) {
        Storage storage = new Storage(storage_dto);
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(storage);
            em.getTransaction().commit();
            return new Storage_dto(storage);
        } finally {
            em.close();
        }
    }

    public Storage_dto updateStorage(Long itemid, int amount) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Storage storage = em.createNamedQuery("Storage.update", Storage.class).setParameter("itemid", itemid).getSingleResult();
            storage.setAmount(amount);
            em.merge(storage);
            em.getTransaction().commit();
            return new Storage_dto(storage);
        } catch (Exception e) {
            Item_dto item_dto;
            Item item = em.find(Item.class, itemid);
            item_dto = new Item_dto(item);
            Storage_dto storage = new Storage_dto(item_dto, itemid, amount);
            return addToStorage(storage);
        } finally {
            em.close();
        }
    }

    public List<Recipe_dto> getRecipes() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            List<Recipe> recipes = em.createNamedQuery("Recipe.all").getResultList();
            List<Recipe_dto> recipesDTO = new ArrayList();
            recipes.forEach((recipe) -> {
                recipesDTO.add(new Recipe_dto(recipe));
            });
            return recipesDTO;
        } finally {
            em.close();
        }
    }

    public List<Menu_dto> getAllMenues() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            List<WeekMenuPlan> ws = em.createNamedQuery("WMP.all").getResultList();
            em.getTransaction().commit();
            List<Menu_dto> menu_dto = new ArrayList();
            ws.forEach(w -> {
                menu_dto.add(new Menu_dto(w));
            });
            return menu_dto;
        } finally {
            em.close();
        }
    }

    public Menu_dto addTheWeek(Menu_dto menu_dto) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            WeekMenuPlan w = new WeekMenuPlan(menu_dto);
            em.persist(w);
            em.getTransaction().commit();
            return new Menu_dto(w);
        } finally {
            em.close();
        }
    }

    public Item_dto addToItems(Item_dto item_dto) {
        Item item = new Item(item_dto);
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
            return new Item_dto(item);
        } finally {
            em.close();
        }
    }

    public void popDB(){
           EntityManager em = emf.createEntityManager();
     try {
            em.getTransaction().begin();

            Item pepperoni = em.find(Item.class, 20);
            Item burgerPattie = em.find(Item.class, 30);
            Item fries = em.find(Item.class, 15);
            Item pizza = em.find(Item.class, 20);
            Item steak = em.find(Item.class, 50);
            Item potatoes = em.find(Item.class, 10);
            Item fish = em.find(Item.class, 30);
            Item salad = em.find(Item.class, 10);
            Item hotdog = em.find(Item.class, 10);
            Item bun = em.find(Item.class, 15);
            Item tomato = em.find(Item.class, 10);
            Item pasta = em.find(Item.class, 9);

            Ingredient burgerPattieSingle = new Ingredient(50, burgerPattie);
            em.persist(burgerPattieSingle);

            Ingredient pepperoniSlice = new Ingredient(200, pepperoni);
            em.persist(pepperoniSlice);

            Ingredient friesI = new Ingredient(500, fries);
            em.persist(friesI);

            Ingredient pizzaBottom = new Ingredient(50, pizza);
            em.persist(pizzaBottom);

            Ingredient steakIn = new Ingredient(30, steak);
            em.persist(steakIn);

            Ingredient potatoesIn = new Ingredient(50, potatoes);
            em.persist(potatoesIn);

            Ingredient fishWhite = new Ingredient(30, fish);
            em.persist(fishWhite);

            Ingredient saladIceberg = new Ingredient(10, salad);
            em.persist(saladIceberg);

            Ingredient hotdogIn = new Ingredient(80, hotdog);
            em.persist(hotdogIn);

            Ingredient bunIn = new Ingredient(60, bun);
            em.persist(bunIn);

            Ingredient tomatoIn = new Ingredient(50, tomato);
            em.persist(tomatoIn);

            Ingredient pastaIn = new Ingredient(110, pasta);
            em.persist(pastaIn);

            Recipe burgerFries = new Recipe("burger and fries", 15, "Cook burger and fries. Put the burger in bun, add fries to plate");
            friesI.setRecipe(burgerFries);
            bunIn.setRecipe(burgerFries);
            burgerPattieSingle.setRecipe(burgerFries);

            em.persist(burgerFries);

            Recipe pizzaPepperoni = new Recipe("pizza pepperoni", 20, "Put tomato and pepperoni on pizza bottom and put in oven");
            pizzaBottom.setRecipe(pizzaPepperoni);
            tomatoIn.setRecipe(pizzaPepperoni);
            pepperoniSlice.setRecipe(pizzaPepperoni);

            em.persist(pizzaPepperoni);

            Recipe steakPotato = new Recipe("steak and potatoes", 15, "Cook steak and potatoes. Put on plate");
            steakIn.setRecipe(steakPotato);
            potatoesIn.setRecipe(steakPotato);
            em.persist(steakPotato);

            Recipe SaladR = new Recipe("Simple Salad", 5, "Put iceberg with tomatoes into bowl");
            saladIceberg.setRecipe(SaladR);
            tomatoIn.setRecipe(SaladR);
            em.persist(SaladR);

            Recipe fishFries = new Recipe("Fish and fries", 20, "Cook fish and fries. Put on plate");
            friesI.setRecipe(fishFries);
            fishWhite.setRecipe(fishFries);
            em.persist(fishFries);

            Recipe hotdogBun = new Recipe("Hotdog in a bun", 5, "Cook hotdog put in bun");
            hotdogIn.setRecipe(hotdogBun);
            bunIn.setRecipe(hotdogBun);
            em.persist(hotdogBun);

            Recipe pastaTomato = new Recipe("Pasta with tomato", 10, "Cook pasta and cut tomato then put in bowl");
            pastaIn.setRecipe(pastaTomato);
            tomatoIn.setRecipe(pastaTomato);
            em.persist(pastaTomato);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
