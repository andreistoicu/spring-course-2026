1. Add spring dependencies
   Add application context to main method
   Implement AppConfig class
   Define Bean1 with @Component annotation
   Define Bean2 with @Bean + @Configuration
   Define Bean3 with @Service annotation
   Define Bean4 with @Repository annotation
   Define Bean5 in another package
   Define Bean6 in xml config file - applicationContext.xml

2. Create 4 beans:  Bean7, Bean8 and Bean9, Bean10 where:
- Bean7 will be injected in Bean8 via **ConstructorInjection**
- Bean7 will be injected in Bean9 via  **SetterInjection**
- Bean7 will be injected in Bean10 via @Autowired

3.Create SpringBean11 and print a message inside the constructor, 
**with scope prototype** and inject into Bean8 And Bean9


**HTML**

Create a HTML document that includes:
A title "My Webpage It School"
A heading (h1) with the text "Welcome Timisoara"
A paragraph with the text "This is my first HTML page. I'm learning how to create web pages using HTML."

Create a HTML document that includes:
first html - hobbies.html
- a heading(h2) with the text "My Favorite Hobbies"
- an unordered list of your three favorite hobbies

second html
- a heading(h2) with the text "Useful Links"
- 3 hiperlinks to your favorite websites. Use descriptive text for the links.

3rd html
- a heading(h3) with the text "My favorite animal"
- an image of your favorite animal. Use the alt attribute to provide alternative text for the image.

4rd html
- a heading(h1) with the text "My daily routine"
- an ordered list with at least 3 items representing the daily routine.
- Within one of the list items, include a nested unordered list with sub-tasks or activities.

DB1. Save a Book entity with columns for id, version, title, price and embeddable Author (name, age) in a database.

DB2. Update and findAll on the Book entity (title , price , version)