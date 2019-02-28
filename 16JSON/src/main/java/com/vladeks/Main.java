package com.vladeks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.vladeks.model.Gem;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    // write your code here
//        byte[] jsonData = Files.readAllBytes(Paths.get("E:\\Projects\\EPAMtask\\16JSON\\src\\main\\java\\com\\vladeks\\gem.json"));
//        ObjectMapper mapper = new ObjectMapper();

        /*Gem gem = mapper.readValue(jsonData, Gem.class);
        System.out.println(gem.toString());*/
//        Gem gem = new Gem();
//        JsonNode node = mapper.readTree(jsonData).get("gem");
//        gem.setName(node.get("name").toString());
//        gem.setOrigin(node.get("origin").toString());
//        gem.setPreciousness(node.get("preciousness").toString());
//        gem.setValue(node.get("value").toString());
//        Gem.VisualParameters visualParameters = gem.new VisualParameters();
//        JsonNode vNode = node.get("visualParameters");
//        visualParameters.setColor(vNode.get("color").toString());
//        visualParameters.setDiamondCut(vNode.get("diamondCut").toString());
//        visualParameters.setTransparency(vNode.get("transparency").toString());
//        gem.setVisualParameters(visualParameters);
//        System.out.println(gem.toString());

    public static void main(String[] args) throws IOException {

        File json = new File("D:\\Projects\\EPAMtask\\16JSON\\src\\main\\resources\\gem.json");
        File schema = new File("D:\\Projects\\EPAMtask\\16JSON\\src\\main\\resources\\gem_scheme.json");
        System.out.println("Jacson");
        jacsonParse(json);

//        validate(json, schema);
//        System.out.println("Gson");
//        gsonParse(json);

    }

    public static void validate(File json, File schem) throws IOException {

        JSONObject jsonSchema = new JSONObject(
                new JSONTokener(Files.newInputStream(schem.toPath())));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(Files.newInputStream(json.toPath())));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }

    public static void jacsonParse(File json) {
        ObjectMapper mapper = new ObjectMapper();
        Gem[] gems = new Gem[0];
        try {
            gems = mapper.readValue(json, Gem[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(gems));
    }

    public static void gsonParse(File json) {
        Gson gson = new Gson();
        Gem[] gems = gson.fromJson(json.getPath(), Gem[].class);
        System.out.println(Arrays.toString(gems));

    }
}
