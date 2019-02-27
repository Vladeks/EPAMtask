package com.vladeks;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        byte[] jsonData = Files.readAllBytes(Paths.get("E:\\Projects\\EPAMtask\\16JSON\\src\\main\\java\\com\\vladeks\\gem.json"));
        ObjectMapper mapper = new ObjectMapper();

        /*Gem gem = mapper.readValue(jsonData, Gem.class);
        System.out.println(gem.toString());*/
        Gem gem = new Gem();
        JsonNode node = mapper.readTree(jsonData).get("gem");
        gem.setName(node.get("name").toString());
        gem.setOrigin(node.get("origin").toString());
        gem.setPreciousness(node.get("preciousness").toString());
        gem.setValue(node.get("value").toString());
        Gem.VisualParameters visualParameters = gem.new VisualParameters();
        JsonNode vNode = node.get("visualParameters");
        visualParameters.setColor(vNode.get("color").toString());
        visualParameters.setDiamondCut(vNode.get("diamondCut").toString());
        visualParameters.setTransparency(vNode.get("transparency").toString());
        gem.setVisualParameters(visualParameters);
        System.out.println(gem.toString());


    }
}
