package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import java.util.List;

import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
     /*   String sampleSchema="{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-06/schema#\",\n" +
                "  \"$ref\": \"#/definitions/Welcome9\",\n" +
                "  \"definitions\": {\n" +
                "    \"Welcome9\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"additionalProperties\": false,\n" +
                "      \"properties\": {\n" +
                "        \"firstName\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"age\": {\n" +
                "          \"type\": \"integer\"\n" +
                "        },\n" +
                "        \"address\": {\n" +
                "          \"$ref\": \"#/definitions/Address\"\n" +
                "        },\n" +
                "        \"phoneNumbers\": {\n" +
                "          \"type\": \"array\",\n" +
                "          \"items\": {\n" +
                "            \"$ref\": \"#/definitions/PhoneNumber\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"address\",\n" +
                "        \"age\",\n" +
                "        \"firstName\",\n" +
                "        \"phoneNumbers\"\n" +
                "      ],\n" +
                "      \"title\": \"Welcome9\"\n" +
                "    },\n" +
                "    \"Address\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"additionalProperties\": false,\n" +
                "      \"properties\": {\n" +
                "        \"streetAddress\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"format\": \"integer\"\n" +
                "        },\n" +
                "        \"city\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"state\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"postalCode\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"format\": \"integer\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"city\",\n" +
                "        \"postalCode\",\n" +
                "        \"state\",\n" +
                "        \"streetAddress\"\n" +
                "      ],\n" +
                "      \"title\": \"Address\"\n" +
                "    },\n" +
                "    \"PhoneNumber\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"additionalProperties\": false,\n" +
                "      \"properties\": {\n" +
                "        \"type\": {\n" +
                "          \"type\": \"string\"\n" +
                "        },\n" +
                "        \"number\": {\n" +
                "          \"type\": \"string\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"required\": [\n" +
                "        \"number\",\n" +
                "        \"type\"\n" +
                "      ],\n" +
                "      \"title\": \"PhoneNumber\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        ObjectMapper jacksonObjectMapper = new ObjectMapper();
       JsonNode jsonNode= jacksonObjectMapper.readTree(sampleSchema);
       System.out.println(jsonNode);*/




        I i=new C1();
        i.m1();
        i=new C2();
        i.m1();

    }



}
