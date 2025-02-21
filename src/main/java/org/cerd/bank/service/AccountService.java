package org.cerd.bank.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cerd.bank.model.User;
import org.cerd.bank.util.GenerateHash;
import org.cerd.bank.util.ValidateUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.cerd.bank.model.User.getFile;

public class AccountService {
    public AccountService() {
    }

    ValidateUtil validateUtil = new ValidateUtil();
    GenerateHash hashCode = new GenerateHash();

    public void createAccount(String name, Integer age, String cellPhone, String cpf) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setAge(age);
        newUser.setCpf(cpf);
        newUser.setCellPhone(cellPhone);
        String hash = hashCode.hashGenerate(name, cpf);
        newUser.setHash(hash);

        if (validateUtil.validate(cpf, newUser.getHash())) {
            System.out.println("User already exists. Account cannot be created.");
        } else {
            System.out.println("User not found. Creating account...");
            addUser(newUser);
        }
    }

    private void addUser(User user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("src/main/resources/users.json");
            if (file.exists() && file.length() > 0) {
                List<User> users = objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
                users.add(user);
                objectMapper.writeValue(file, users);
                System.out.println("New user added.");
            } else {
                List<User> users = List.of(user);
                objectMapper.writeValue(file, users);
                System.out.println("New file created and user added.");
            }
        } catch (IOException e) {
            System.out.println("Error reading or creating the JSON file: " + e.getMessage());
        }
    }

    public static void newDeposit(String cpf, Double amount) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = objectMapper.readValue(new File(getFile()), new TypeReference<>()
        {});
        boolean userFound = false;
        for (User user : users) {
            if (user.getCpf().equals(cpf)) {
                if (user.getBalance() == null) {
                    user.setBalance(amount);
                } else {
                    user.setBalance(user.getBalance() + amount);
                }
                userFound = true;
                System.out.println("User found!");
                break;
            }
        }

        if (!userFound) {
            System.out.println("User not found!");
            return;
        }

        objectMapper.writeValue(new File(getFile()), users);
        System.out.println("Deposit with successful!");
    }

    public boolean transfer(String name, String CPF)
    {
        return false;
    }

    public boolean withdrawal(Float value)
    {
        return false;
    }
}
