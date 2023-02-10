package br.edu.ifba.saj.fwads.controller.auth;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.User;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class OAuthGoogleAuthenticator {

    private User user;

    private Stage stage;

    private List<String> SCOPES = Arrays.asList(
        "https://www.googleapis.com/auth/userinfo.profile",
        "https://www.googleapis.com/auth/userinfo.email");
    private GoogleAuthorizationCodeFlow flow = null;
    private GoogleClientSecrets clientSecrets = null;

    private GoogleClientSecrets getClientSecrets() {
        if (clientSecrets == null) {
            try {
                clientSecrets = GoogleClientSecrets.load(GsonFactory.getDefaultInstance(),
                    new InputStreamReader(App.class.getResourceAsStream("client_secret.json")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return clientSecrets;
    }

    public OAuthGoogleAuthenticator() {
        try {
            java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".store/oauth2_sample");
            FileDataStoreFactory dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);
            flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), GsonFactory.getDefaultInstance(),
                getClientSecrets(), SCOPES).setDataStoreFactory(
                    dataStoreFactory)
                .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    String getWebUrl() {
        GoogleAuthorizationCodeRequestUrl googleAuthorizationCodeRequestUrl = flow.newAuthorizationUrl();
        googleAuthorizationCodeRequestUrl.setRedirectUri(getRedirectUri());
        return googleAuthorizationCodeRequestUrl.build();
    }

    private String getRedirectUri() {

        return getClientSecrets().getWeb().getRedirectUris().get(1);
    }

    GoogleTokenResponse newTokenRequest(String code) {
        try {
            GoogleAuthorizationCodeTokenRequest authorizationCodeTokenRequest = flow.newTokenRequest(code);
            authorizationCodeTokenRequest.setRedirectUri(getRedirectUri());
            GoogleTokenResponse googleTokenResponse = authorizationCodeTokenRequest.execute();
            return googleTokenResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public User startLogin() {



        stage = new Stage();
        WebView root = new WebView();
        WebEngine engine = root.getEngine();

        engine.load(getWebUrl());

        engine.locationProperty().addListener(observable -> {

            String location = ((ReadOnlyStringProperty) observable).get();
            if (location.contains("code") && location.startsWith(getRedirectUri())) {

                closeStage();

                String accessCode = location.substring(location.indexOf("code=") + 5, location.indexOf("&"));
                try {
                    accessCode = java.net.URLDecoder.decode(accessCode, StandardCharsets.UTF_8.name());
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

                GoogleTokenResponse googleTokenResponse = newTokenRequest(accessCode);

                GoogleIdToken idToken = null;
                try {
                    idToken = googleTokenResponse.parseIdToken();
                    GoogleIdToken.Payload payload = idToken.getPayload();
                    String userId = payload.getSubject();  // Use this value as a key to identify a user.
                    String email = payload.getEmail();
                    String picture = payload.get("picture").toString();
                    user = new User(userId, email, picture);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();

        return user;
    }

    private void closeStage() {
        stage.close();

    }
}