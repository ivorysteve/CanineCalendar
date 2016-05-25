# Canine Calendar

### A scheduling app for dog visits.

This application is intended to be used by groups like Caring Canines, where dogs
and their owners go on short (half-hour) visits, in groups of 1-8 dogs, to nursing homes, hospitals, and child care centers.
The application allows the user to register new dogs, create new clients, and edit the details of a visit (specific dogs
assigned).  It implements business rules for choosing a set of dogs (who have volunteered) based on eligibility,
least chosen, and other attributes.

### What's inside?

The application implements a RESTful API running on an Apache Tomcat server, and uses the following technologies:

* Java 8
* Spring Boot
* Spring MVC
* JaCoP Constraint Programming library (for Java)
* Hibernate
* MySQL (persistence layer)
* JUnit (tests)
* Swagger 2 (documentation)

A UI component for Canine Calendar, using React.js and Flux, is in the works.

***Author***: Stephen Gilbane

## TODO ##
* Create, delete Visits
* State changes for VisitDogs.
* Doc on all Controllers.
