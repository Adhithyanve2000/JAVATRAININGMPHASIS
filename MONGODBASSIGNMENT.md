// ================================================
// Q.1) Find all users with age greater than 25
// ================================================
db.Users.find({ age: { $gt: 25 } })

// ================================================
// Q.2) Find all users where the 'status' field exists
// ================================================
db.Users.find({ status: { $exists: true } })

// ================================================
// Q.3) Update the 'status' of user named 'Bob' to 'active'
// ================================================
db.Users.updateOne({ name: 'Bob' }, { $set: { status: 'active' } })

// ================================================
// Q.4) Increment 'age' of user named 'Alice' by 1
// ================================================
db.Users.updateOne({ name: 'Alice' }, { $inc: { age: 1 } })

// ================================================
// Q.5) Find all products with price less than or equal to 500
// ================================================
db.products.find({ price: { $lte: 500 } })

// ================================================
// Q.6) Find all products that have 'electronics' tag
// ================================================
db.products.find({ tags: { $in: ["electronics"] } })

// ================================================
// Q.7) Set 'stock' field to 100 for all products
// ================================================
db.products.updateMany({}, { $set: { stock: 100 } })

// ================================================
// Q.8) Rename the 'price' field to 'cost' in all products
// ================================================
db.products.updateMany({}, { $rename: { "price": "cost" } })

// ================================================
// Q.9) Find all orders where 'total' is not equal to 750
// ================================================
db.orders.find({ total: { $ne: 750 } })

// ================================================
// Q.10) Remove the 'items' field from all orders
// ================================================
db.orders.updateMany({}, { $unset: { items: "" } })

// ================================================
// Q.11) Multiply 'total' by 1.1 for all orders
// ================================================
db.orders.updateMany({}, { $mul: { total: 1.1 } })

// ================================================
// Q.12) Find all orders with 'date' greater than "2025-08-05"
// ================================================
db.orders.find({ date: { $gt: "2025-08-05" } })

// ================================================
// Q.13) Find all students who have a grade equal to 100
// ================================================
db.students.find({ grades: { $in: [100] } })

// ================================================
// Q.14) Add grade 88 to 'Eva' only if it doesn't already exist
// ================================================
db.students.updateOne(
  { name: "Eva" },
  { $addToSet: { grades: 88 } }
)

// ================================================
// Q.15) Remove the last element from 'grades' array of 'Frank'
// ================================================
db.students.updateOne(
  { name: "Frank" },
  { $pop: { grades: 1 } }
)

// ================================================
// Q.16) Find students with at least one grade greater than 90
// ================================================
db.students.find({ grades: { $elemMatch: { $gt: 90 } } })

// ================================================
// Q.17) Calculate total salary per department
// ================================================
db.employees.aggregate([
  {
    $group: {
      _id: "$department",
      totalSalary: { $sum: "$salary" }
    }
  }
])

// ================================================
// Q.18) Calculate average salary of all employees
// ================================================
db.employees.aggregate([
  {
    $group: {
      _id: null,
      averageSalary: { $avg: "$salary" }
    }
  }
])

// ================================================
// Q.19) Project only 'name' and 'salary' fields of employees
// ================================================
db.employees.aggregate([
  {
    $project: {
      name: 1,
      salary: 1,
      _id: 0
    }
  }
])

// ================================================
// Q.20) Sort employees by 'salary' in descending order
// ================================================
db.employees.aggregate([
  {
    $sort: { salary: -1 }
  }
])
