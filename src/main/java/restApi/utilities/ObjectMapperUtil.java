package restApi.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ObjectMapperUtil {

    ObjectMapper objectMapper = new ObjectMapper();

    public Object jsonToModel(String json, String packagePath)
            throws ClassNotFoundException, JsonMappingException, JsonProcessingException {

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Class<?> classForName = Class.forName(packagePath);
        
        return objectMapper.readValue(json,classForName);
    }

    public Object jsonToModel(String json, Class<?> classForName)
            throws ClassNotFoundException, JsonMappingException, JsonProcessingException {

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        return objectMapper.readValue(json,classForName);
    }

    public String objectToJson(Object object) throws JsonProcessingException {

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writeValueAsString(object);

        return json;
        
    }

    public Object objectToAnotherObject (Object object, Class<?> classForName) {
        objectMapper = new ObjectMapper();
        return objectMapper.convertValue(object, classForName);

    }

//    public Object parseJsonTree(String json) throws Exception {
//
//        objectMapper = new ObjectMapper();
//        objectMapper.configure(Demvn clean package -DskipTests  -Dmaven.wagon.http.ssl.insecure=trueserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        JsonNode root = objectMapper.readTree(json);
//
//        Map<String,Object>returnMap = new HashMap<String,Object>();
//        String jsonValue;
//
//
//        if(root.isObject()){
//            //LOGGER.info("OBJECT");
//            ObjectNode objectNode = (ObjectNode) root;
//        Iterator<Map.Entry<String, JsonNode>> iter = objectNode.fields();
//
//        while (iter.hasNext()) {
//            Map.Entry<String, JsonNode> entry = iter.next();
//            //LOGGER.info(entry.getKey());
//           //LOGGER.info(entry.getValue());
//            try{
//            jsonValue = StringEscapeUtils.unescapeJava(entry.getValue().textValue());
//            }catch(Exception e){
//            jsonValue = entry.getValue().textValue();
//            }
//            //LOGGER.info(jsonValue);
//            returnMap.put(entry.getKey(),jsonToModel(jsonValue,Object.class));
//        }
//
//        }else if(root.isArray()){
//            //TO-DO
//            //LOGGER.info("ARRAY");
//        }
//
//        return returnMap;
//    }
}