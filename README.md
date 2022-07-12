# [P2E] Design Patterns Challenge

## Description

This is a simulation of an e-commerce application where you can add new products in the database.

 Product class has a lot of fields and creating an instance of that class is quite difficult.

Currently there are 3 types of products: SIMPLE, DOWNLOADABLE, VARIANT. Each of the types has different required fields hence different insert logic.


## Challenges

### 1) Refactor this code by using design patterns

**Hints**:
- Creating a new instance of Product is not easy. What can you do to make that look more clean?
- Have a look at the productService::createProduct method. Does it follow [Open-Close Principle](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle)? What if the store wants to support new types of products in the future?


### 2) Try adding a new type of product
This part should be done after you've successfully completed the first challenge.

The store now wants to support a new product, called `VIRTUAL`. Try adding this new type in the "old" implementation and also in your "clean" one. What conclusions can you draw from that?
