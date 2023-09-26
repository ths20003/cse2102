### Lab 1 Setup - CSE2102 (Team Otters)

# 1. Initialize the program

First, get the program onto your machine.

## 1.1 Clone Repository

Load this program onto your local machine. This can be done by running this command in the terminal:

```
git clone https://github.com/ths20003/cse2102.git
```

## 1.2 Adjust Directory

Make sure that you are in the correct directory. Navigate to Lab 0 with `cd lab1` in the terminal.

## 1.3 Ensure Resources

This program requires the user to have `maven` installed on their machine. The directory for lab1 already has the maven build created, so initializing with maven will not be necessary. Install maven using the following command in terminal:

```
sudo dnf install maven
```

# 2. Run the program

Now that the programs are on your machine, we will compile and run them.

## 2.1 Compiling

Let's make sure the build is set up properly. Run the following command in terminal to compile with maven:
```
mvn compile
```

## 2.2 Running the program / Packaging

Run the following command in terminal to run the tests:
```
mvn package
```

### If done properly, the program should successfully run.
