atm
===

ATM is a very simple Java web application for imaginary POS terminal. It was done JFF.

Frameworks used - Spring MVC, Hibernate.
DB - H2 Server mode

To try it you may need following:

  1. Clone it to local PC (preferably Linux-based)
  2. Go to project root
  3. Start H2 `java -cp ~/WORK/devtools/h2*.jar org.h2.tools.Server`
  4. Build project with `mvn clean install` (it will flyway H2)
  5. Start tomcat
  6. Try ATM login page `http://localhost:8080/login`


Things to improve:

  1. Card number filed is not masked. Cool to have something like this `1111-1111-1111-1111`
  2. UI is awful :) No styles at all ...
  3. No tests at all (must be)
  4. Many checks in controllers are dupplicated (Validation API should help)