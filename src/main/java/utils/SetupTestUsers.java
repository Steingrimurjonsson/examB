package utils;


import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.Role;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords

   User user = new User("user", "pass");
    User admin = new User("admin", "pass");
    User both = new User("user_admin", "pass");

    if(admin.getUserPass().equals("test")/*||user.getUserPass().equals("test")||both.getUserPass().equals("test")*/)
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
  em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
     Item pepperoni = em.find(Item.class, 20l);
            Item burgerPattie = em.find(Item.class, 30l);
            Item fries = em.find(Item.class, 15l);
            Item pizza = em.find(Item.class, 20l);
            Item steak = em.find(Item.class, 50l);
            Item potatoes = em.find(Item.class, 10l);
            Item fish = em.find(Item.class, 30l);
            Item salad = em.find(Item.class, 10l);
            Item hotdog = em.find(Item.class, 10l);
            Item bun = em.find(Item.class, 15l);
            Item tomato = em.find(Item.class, 10l);
            Item pasta = em.find(Item.class, 9l);

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
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("pass"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("12345"));
    System.out.println("Created TEST Users");
   
  }

}
