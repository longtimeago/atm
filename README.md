atm
===

ATM is a very simple Java web application for imaginary POS terminal. It was done JFF.

Frameworks used - Spring MVC, Hibernate.
DB - MySql

To try it you may need following:

  1. Clone it to local PC (preferably Linux-based)
  2. Go to project root
  3. Build project with `mvn clean install`
  4. Start mysql `mvn jcabi-mysql:run` (on port 3306) (you may need perl to be installed)
  5. Init DB `mvn sql:execute`
  6. Start tomcat `mvn tomcat7:run` (on port 8080)
  7. Try ATM login page `http://localhost:8080/login`


Things to improve:

  1. Card number filed is not masked. Cool to have something like this `1111-1111-1111-1111`
  2. UI is awful :) No styles at all ...
  3. No tests at all (must be)
  4. Session is not secured (Spring Security shuld help)
  5. Many checks in controllers are dupplicated (Validation API should help)
