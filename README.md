# backend-spring-boot-docker-with-unit-integration-testing


This is a simple Spring boot application for a booking system which allow a booking company to book trails for hikers using Spring-boot, MySQL and Docker.

To run this application you just need to 

1 - Install docker

2 - /spring-boot-unit-test-rest-controller/docker build -t app .

3 - /docker-compose up

Docker will start 2 containers for you

1 for the MySql running on port 3308

2 for the Backend ( Spring-Boot App ) running on port 8091

![image](https://user-images.githubusercontent.com/65496901/187028369-a86093c4-6b74-4c78-aa6b-9a6c3ad9b72e.png)

Once you start your containers, 3 Trails will be created automatically and you can get them using

GET REQUEST http://localhost:8091/trails

![image](https://user-images.githubusercontent.com/65496901/187028733-1c0733ff-cdbb-4120-96f1-db13b75fbe5b.png)

We can now create new hikers using

POST REQUEST http://localhost:8091/hikers/create

![image](https://user-images.githubusercontent.com/65496901/187028994-f8344932-1eea-43fa-a1d9-0db4cb6d183a.png)

We can see the existing hikers with

GET REQUEST  http://localhost:8091/hikers

![image](https://user-images.githubusercontent.com/65496901/187029100-348e518e-aa66-4e82-b1a6-008d00988060.png)

We can book an existing Trail for one or multiple hikers using

POST REQUEST 

![image](https://user-images.githubusercontent.com/65496901/187029052-4ad9eab8-ecce-4252-bc94-966ca5eac5d2.png)

And finally we can the the hikers inside an existing booking with

http://localhost:8091/bookings-hikers/{id}

![image](https://user-images.githubusercontent.com/65496901/187029129-95389064-b35f-4d49-8bf6-41d451c9bd07.png)










