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

# Disk Caching

Disk caching focuses on storing data on persistent storage so it can survive after the application or system shuts down.

There are two important concepts in disk caching:

## Read Caching

Read caching focuses on improving read performance.

### Cache Hit

If the requested data already exists in the cache (RAM), the system reads directly from the cache without accessing the hard drive.

### Cache Miss

If the data does not exist in the cache:

1. The system reads the data from the hard drive
2. A copy of that data is placed into the cache
3. Future requests become faster because the data is now cached

This reduces expensive disk access operations.

---

## Write Caching

Write caching focuses on how data is written to storage.

There are two common strategies:

### Write-Back Cache

In write-back caching:

1. Data is first written to the cache (RAM)
2. The system later writes the data to the hard drive

This improves performance because RAM is much faster than disk storage.

Example:
When saving a file on a computer, it may appear instantly saved, but the operating system could still be writing the data to disk in the background.

Advantage:

* Very fast writes

Disadvantage:

* If power is lost before data reaches the disk, data can be lost

---

### Write-Through Cache

In write-through caching:

1. Data is written to the cache
2. Data is immediately written to the hard drive as well

Advantage:

* Data consistency and safety

Disadvantage:

* Slower than write-back caching because every write operation reaches the disk immediately

