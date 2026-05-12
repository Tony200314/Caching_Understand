# Introduction

Hi there 👋
This small repository is built to understand the concept of caching, specifically focusing on In-Memory Caching and Disk Caching.

Caching is a technique used to temporarily store frequently accessed data so it can be retrieved faster without repeatedly querying the original data source.

---

# In-Memory Caching

In-Memory Caching stores data directly in the application's memory (RAM), which makes access extremely fast compared to retrieving data from a database.

In this project, we simulate a simple system where:

* A **fake database** is implemented using a `HashMap`
* An **in-memory cache** is implemented using an `ArrayList`

### How it works

Imagine a database containing multiple products.
Instead of querying the database every time a product is requested, the system first checks the cache:

* If the product exists in the cache → it is returned immediately (fast access)
* If the product is not in the cache → it is fetched from the fake database, stored in the cache, and then returned

This demonstrates the basic idea of reducing expensive data access operations by using memory-based storage.

### Key idea

The cache acts as a temporary storage layer between the application and the database, improving performance by avoiding repeated database queries for the same data.

---

# Disk Caching

(To be added)
