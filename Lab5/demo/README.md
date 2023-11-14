**Clone the Repository:**

```shell
git clone https://github.com/moa20016/cse2102.git
```

**Change Directory and Open in VSCode:**

```shell
cd cse2102/Lab5/demo
```

Open the folder in VSCode Virtual Machine in your web browser.

**Edit HomeController.java to have it work with your terminal:**

```shell

cse2102/Lab5/demo/src/main/HomeController.java
```
within this java file, you want to adjust the following found in lines "31" and "42" with your VMID

``redirect:https://NETID-vm.cse.uconn.edu/proxy/8091/not_home``                                                                               ``redirect:https://NETID-vm.cse.uconn.edu/proxy/8091/test``


Run Tests and Launch the Project:
While in the demo folder, run the following commands:

**Running tests:**

```shell

./mvnw test
```

**To make the project run:**

```shell

./mvnw spring-boot:run
```

After running ``./mvn spring-boot:run``,
go on the ``Ports`` tab in the terminal and make sure to forward port 8091
Open in Browser and Test it out.
