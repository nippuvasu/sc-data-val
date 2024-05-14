### Project Set up and Execution

You can set up projects for yourself by following these steps:

- Clone it locally 
- Import into any IDE, build and run as springboot project
- once the appliaction is up and running, you can access loadl H2 DB using the browser http://localhost:8080/h2-console ( username : sa , password : password)
- you can invoke the customer register endpoint : localhost:8080/api/customer/new ( POST ) --using the below sample request payload
-   {
    "name": "scd",
    "email":"sc@gmail.com",
    "phone":"123-456-7891",
    "ssn":"322-90-2222",
    "birthDate":"2022-10-22"
}

- Once the request is processed succesfully, you can see the record inserted into H2 DB, refresh H2 console and query the customer table  :SELECT * FROM CUSTOMER 
