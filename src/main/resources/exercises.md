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