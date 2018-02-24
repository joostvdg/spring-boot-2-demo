# spring-boot-2-demo

Based on these tutorias:

* https://www.djamware.com/post/59be51e780aca768e4d2b140/tutorial-of-building-java-rest-api-using-spring-boot-and-mongodb
* https://dzone.com/articles/spring-boot-with-embedded-mongodb



## Use the API

* http://localhost:8085/products 

### Insert product

```bash
curl -i -X POST -H "Content-Type: application/json"\
    -d '{"prodName":"Dummy Product 1","prodDesc":"The Fresh Dummy Product in The world part 1","prodPrice":100,"prodImage":"https://dummyimage.com/600x400/000/fff"}' \
    localhost:8085/products
``` 
