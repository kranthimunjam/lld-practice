package org.payment.gateway.data.clientdata;

import org.payment.gateway.client.Client;

import java.util.HashMap;
import java.util.Map;

public class ClientStore {
    Map<Integer, Client> clientMap;
    static ClientStore instance;

    private ClientStore() {
        clientMap = new HashMap<>();
    }

    public static ClientStore getInstance() {
        if (instance == null) {
            instance = new ClientStore();
        }
        return instance;
    }

    public Client getClient(int id) {
        if(hasClient(id)) return clientMap.get(id);
        else return null;
    }

    public void addClient(Client client) {
        instance.clientMap.put(client.getId(), client);
    }

    public void removeClient(Client client) {
        instance.clientMap.remove(client.getId());
    }

    public boolean hasClient(int clientId){
        return clientMap.containsKey(clientId);
    }
}
