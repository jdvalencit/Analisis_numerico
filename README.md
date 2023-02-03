# <center>SmartMath User's Manual!

Hello! Welcome to the **SmartMath** User Manual. This manual was created with the objective of facilitating the process of using the SmartMath web platform by explaining the implemented methods and their restrictions. You will also find different sections that may be of interest for your knowledge of the project.

We invite you to take a complete look at all the facilities offered by the manual in order to avoid making mistakes that may worsen your experience.


# Introduction

This platform was developed as a final project of the **Numerical Analysis** course taught in the undergraduate course of Systems Engineering together with Mathematical Engineering course. It was created under the need to propose optimal solutions to various problems in the field of computational mathematics (among these solution of systems of equations, interpolation, etc.).

**Computational mathematics** is the discipline that models and solves problems that arise in the scientific, technological and industrial fields. It uses mathematical and statistical models developed on the basis of computation.
# Objectives

The purpose of this project is to provide the course members (students and teacher) with the necessary tools to carry out different mathematical problem solving processes. The main objective is the implementation of numerical methods seen throughout the course.

## Specific objectives

- Visualization of the information available in the execution of the function (Intervals, iterations, results, etc).
- Implementation of more than 20 methods seen in the course.
- Implementation of specific sections for each method (adapting the required inputs).

# Restrictions

SmartMath is designed as a web development in order to stand out for its ease of use and low volatility in the change of environment. This allows that there are no hardware restrictions and that the software restrictions are limited only to aspects such as the browser version.

However, in case of wanting to make use of the methods used for the development of the platform (i.e., the methods mentioned initially), different aspects must be taken into account, among which the following stand out:
- Development done in Python and Java as a second language (There is no integration between these, they are independent languages).
- Versions used:
    - Python: 3.81
    - Java: JDK 14
- Operating system used:
    - Windows 11 Home Edition

# Contents

The list of methods implemented in the final version of SmartMath is:

- Methods for numerical solution of systems of nonlinear equations.
    - Open methods.
        - Newton.
        - Fixed point.
        - Multiple roots.
        - Secant.
    - Closed methods.
        - Bisection.
        - False rule.
    - Determining initial values.
        - Incremental searches.
- Methods for numerical solution of systems of linear equations.
    - Pivoting
        - Partial Pivoting
        - Total Pivoting
    - Iterative methods
        - Gauss-Seidel
        - Jacobi
    - LU factorization
        - LU by Gauss
        - LU Partial Pivoting (Source Code)
	    - Direct methods
		    - Crout
		    - Dolittle
		    - Cholesky
    - Gaussian Elimination
- Interpolation
    - Lagrange
    - Newton
    - Splines
        - Linear
        - Quadratics
    - Neville (Source Code)

# <center>Guide

In this guide the steps to follow to make use of the methods implemented in **SmartMath** will be presented. This includes: parameters, constraints, expected results, etc.


## Methods for the numerical solution of nonlinear equations

### Newton

Newton receives as parameters:

- f : main function to be used
- f' : derivative of the main function (i.e. of f)
- xi : initial value
- tol : tolerance
- n : maximum number of iterations
- errortype : type of error to use (absolute or relative)

![enter image description here](https://i.ibb.co/XWPYf84/Newton.png)

### Fixed point

Fixed point receives as parameters:

- f : main function to use
- g : secondary function to be used
- xi : initial value
- tol : tolerance
- n : maximum number of iterations
- errortype : type of error to use (absolute or relative)

![enter image description here](https://i.ibb.co/LJd3hY2/Fixed-Point.png)

### Multiple roots

Multiple roots receives as parameters:

- f : main function to use
- df : derivative of the main function (i.e. of f)
- d2f : second derivative of the main function (i.e. of f)
- xi : initial value
- tol : tolerance
- n : maximum number of iterations
- errortype : type of error to use (absolute or relative)

![enter image description here](https://i.ibb.co/KWPBc4S/Multiple-roots.png)

### Secant

Secant receives as parameters:

- f : main function to be used
- interval : interval to work on
- tol : tolerance
- n : maximum number of iterations
- errortype : type of error to use (absolute or relative)

![enter image description here](https://i.ibb.co/qn6kLHz/Secant.png)

### Bisection

Bisection receives as parameters:

- f : main function to be used
- xi : initial value
- xf : final value
- tol : tolerance
- errortype : type of error to use (absolute or relative)

***Due to the nature of these variables, xi must be less than xf.***

![enter image description here](https://i.ibb.co/N6mnXLL/Bisection.png)

### False rule

Rule false receives as parameters:

- f : main function to be used
- xi : initial value
- xf : final value
- tol : tolerance
- errortype : type of error to use (absolute or relative)

***Due to the nature of these variables, xi must be less than xf.***

![enter image description here](https://i.ibb.co/yVC2nwY/false-rule.png)

### Incremental search

Incremental searches receive as parameters:

- f : main function to be used
- x0 : initial value
- dx : delta of x (value to increment in each iteration)
- n : maximum number of iterations

![enter image description here](https://i.ibb.co/y4k1kgT/incremental-search.png)

## Methods for Numerical Solution of Linear Equations

### Partial Pivoting

Partial pivoting receives as parameters:

- matrix : matrix A
- b : vector of independent terms

***Matrix must be square***

![enter image description here](https://i.ibb.co/DkfHDXk/partial-pivot.png)

### Total Pivot

Total Pivot receives as parameters:

- matrix : matrix A
- b : vector of independent terms
- variables : labels of the variables (due to the possible change of columns)

***Matrix must be square***

![enter image description here](https://i.ibb.co/09D7nqG/total-pivot.png)

### Gauss-Seidel

Gauss Seidel receives as parameters:

- matrix : matrix A
- b : vector of independent terms
- init : vector of initial values
- tol : tolerance
- n : maximum number of iterations

***Matrix must be square***

![enter image description here](https://i.ibb.co/SV5xv0D/Gauss-seidel.png)

### Jacobi

Jacobi receives as parameters:

- matrix : matrix A
- b : vector of independent terms
- init : vector of initial values
- tol : tolerance
- n : maximum number of iterations

***Matrix must be square***

![enter image description here](https://i.ibb.co/m8DKzbQ/Jacobi.png)

### LU Gauss

LU Gauss receives as parameters:

- matrix : matrix A 
- b : vector of independent terms

***Matrix must be square***

![enter image description here](https://i.ibb.co/3ptv9bX/LU-Gauss.png)

### Gaussian Elimination

Gaussian Elimination receives as parameters:

- matrix : matrix A
- b: vector of independent terms

***Matrix must be square***

![enter image description here](https://i.ibb.co/SVGJn6m/Gaussian-elimination.png)

### Crout

Crout receives as parameters:

- matrix : matrix A
- b : vector of independent terms

***Matrix must be square***

![enter image description here](https://i.ibb.co/txrxT4T/crout.png)

### Dolittle

Dolittle receives as parameters:

- matrix : matrix A
- b : vector of independents terms

***Matrix must be square***

![enter image description here](https://i.ibb.co/pzVf67q/Screenshot-3.png)

### Cholesky

Cholesky receives as parameters:

- matrix : matrix A
- b : vector of independents terms

***Matrix must be square***

![enter image description here](https://i.ibb.co/gZfFQVY/cholesky.png)

## Interpolation

### Lagrange Interpolation

Lagrange Interpolation receives as parameters:

- points : tuples of x and y values

**Input example:** (3.0, 2.5),(4.5, 1.0),(7.0, 2.5)

![enter image description here](https://i.ibb.co/G0T0mkd/Lagrange.png)

### Newton Interpolation

Newton Interpolation receives as parameters:

- points : tuples of x and y values

**Input example:** (3.0, 2.5),(4.5, 1.0),(7.0, 2.5)

![enter image description here](https://i.ibb.co/F31Tdvh/Newton-Interpolation.png)

### Splines (Linear and quadratic)

Splines receives as parameters:

- points : tuples of x and y values

**Input example:** (3.0, 2.5),(4.5, 1.0),(7.0, 2.5)

![enter image description here](https://i.ibb.co/ngRm6jH/Splines.png)

# Parameters for the use of the methods

The following is the format and rules that will govern the inputs required by the platform for the use of the different mathematical methods.

### Functions

A function consists of the relationship between an element of a group A and another element of a group B, provided that they are uniquely and exclusively linked. Therefore, such a function can be expressed in algebraic terms.

The functions must be expressed in terms of x.

Since SmartMath has a connection with the Python Math library, it is possible to use the functions (that are valid) present in this library. Some of these are:

- pow(x, y) : Raise a number x to an exponent y. **You can also use x ** y**.
- log(x) : Natural logarithm of x.
- log(x, y) : Logarithm of x in base y.
- sin(x) : Sine of x.
- cos(x) : Cosine of x.
- tan(x) : Tangent of x.

An example of a valid function for use in the methods is:

$$
\log(\sin({x})^{**}2+1)-1/2
$$

### Matrices

Matrices are "maps" of numeric values (in the case of the project they are integers or floating point, it is not necessary to add the decimal format to integers). The way to enter a matrix in any input that requires it is as follows:

> Enter each row of the matrix in square brackets, separating the different rows by commas. That is, if you want to enter a 3x3 matrix consisting of the numbers 1,2,3,4,5,5,6,7,8,9 in that specific order "visually", the matrix input would look like this:
> 

$$
[1,2,3],[4,5,6],[7,8,9]
$$

It is important to note that the methods may require arrays of different sizes that are specified in the guide.

### Vectors

A vector is defined as an array (list) of numeric values (integer or floating point). The way to enter a vector in any input that requires it is as follows:

> Enter the points of the vector separated by commas and enclosed in square brackets. That is, if I want to enter a vector composed of the numbers 1 to 5, the matrix input would look like this:
> 

$$
[1,2,3,4,5]
$$

It is important to keep in mind that in the case of SmartMath, vectors usually accompany the matrices in the inputs of the methods. So they must have the same size (i.e., if the matrix has X number of rows, the vector must be of size X).

### Initial and final values, tolerance, number of iterations and type of error.

**Initial and final values:** These are the values that we stipulate as lower and upper limits for working with the different methods. That is, they act as the limits of the intervals in which these methods will work. They are entered as integer or decimal values. Example:

$$
xi = 1.5  
$$
$$
xf = 4
$$

In the case of iterative methods, **init** is the starting point to begin iterating, also to be entered as an integer or decimal value.

**Tolerance:** In terms of measurement, the difference between the maximum and minimum dimensions of the allowed errors is called tolerance. That is, it is the limit we stipulate as the "minimum to be achieved" between the obtained and actual results. This is expressed as a decimal number, for example:

$$
0.00001
$$

Which would be equivalent to 10 raised to -5.

**Number of iterations:** It is the limit that we stipulate so that at the moment of executing the different methods, they do not end up generating inefficiencies and/or unnecessary processing. It is written as an integer and represents that the program should **NEVER** go beyond that number, whether it gets a result or not. Example:

$$
N = 100
$$

**Error type:**  SmartMath allows you to select which type of error you want to use (and work based on this for tolerance) between absolute error and relative error, the differences between these are:

- Absolute Error: Error that results as the difference between the obtained value and the true value of a measurement.
- Relative error: Error determined by dividing the absolute error by the true value. That is, it can be understood as the percentage difference.

## The following are some examples of how to make a correct input

|                 |CORRECT INPUT                  |INCORRECT INPUT              |
|---------------- |-------------------------------|-----------------------------|
|Functions        |`log(sin(x)**2+1)*-1/2`        |`log(sinx^2+1)-1/2`          |
|Matrices         |`[1,2],[3,4]`                  |`[1,2][3,4]`                 |
|Vectors          |`[10,15]`                      |`10,15`                      |
|Tolerance        |`0.000001`                     |`10^-6`                      |
|Iterations Amount|`100`                          |`-100`                       |
|                 |                               |                             |
