//package _20lambdaexpressions.shop

// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all(isCity(city))

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = customers.any(isCity(city))

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = customers.count(isCity(city))

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.firstOrNull(isCity(city))

private fun isCity(city : City) : (Customer) -> Boolean = {it.city == city}

/// max & min & sum
// Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = customers.maxBy { it.orders.count() }

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? = orders.flatMap({ it.products }).maxBy({ it.price })

// Return the sum of prices of all products that a customer has ordered.
// Note: the customer may order the same product for several times.
fun Customer.getTotalOrderPrice(): Double = orders.flatMap { it.products }.sumByDouble { it.price }


/// sort
// Return a list of customers, sorted by the ascending number of orders they made
fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> = customers.sortedBy({ it.orders.size })


///groupBy
// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }

/// partition
// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = customers.filter {
    val (del, und) = it.orders.partition { it.isDelivered }
    und.size > del.size
}.toSet()


/// partition
// Return the set of products that were ordered by every customer
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    return customers.fold(allOrderedProducts) { orderedByAll, customer ->
        val orderedProducts = customer.orders.flatMap { it.products }.toSet()
        orderedByAll.intersect(orderedProducts) // [X] intersect [X;C;V] = [X] == retainAll
    }
}

val Customer.orderedProducts: Set<Product>
    get() {
        return orders.flatMap({ it.products }).toSet()
    }

val Shop.allOrderedProducts: Set<Product>
    get() {
        return customers.flatMap({ it.orderedProducts }).toSet()
    }

/// flatMap Вместо геттеров:
// Return all products this customer has ordered
//fun Customer.getOrderedProducts(): Set<Product> = orders.flatMap { it.products }.toSet()

// Return all products that were ordered by at least one customer
//fun Shop.getAllOrderedProducts(): Set<Product> = customers.flatMap { it.getOrderedProducts() }.toSet()


