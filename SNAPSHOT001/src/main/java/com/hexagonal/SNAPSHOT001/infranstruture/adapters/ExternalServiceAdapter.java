package com.hexagonal.SNAPSHOT001.infranstruture.adapters;
import com.hexagonal.SNAPSHOT001.domain.models.AdditionalTaskInfo;
import com.hexagonal.SNAPSHOT001.domain.ports.out.IExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements IExternalServicePort{
    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();
        if (todo == null) {
            return null;
        }
        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderTodo.JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(apiUrl, JsonPlaceHolderTodo.JsonPlaceHolderUser.class);
        JsonPlaceHolderTodo.JsonPlaceHolderUser user = userResponse.getBody();
        if (user==null){
            return null;
        }
        return new AdditionalTaskInfo(user.getId(),user.getName(), user.getEmail());
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaslInfo(Long taskId) {
        return null;
    }

    private static class  JsonPlaceHolderTodo{
        private Long id;
        private String userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
        private static class JsonPlaceHolderUser{
            private Long id;
            private String name;
            private String email;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
    }
}