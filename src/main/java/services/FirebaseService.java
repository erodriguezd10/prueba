/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseService {
    private static FirebaseService instance;
    private Firestore firestore;
    
    private FirebaseService() {
        initializeFirebase();
    }
    
    public static synchronized FirebaseService getInstance() {
        if (instance == null) {
            instance = new FirebaseService();
        }
        return instance;
    }
    
    private void initializeFirebase() {
        try {
            // Ruta absoluta al archivo de credenciales (fuera del proyecto)
            FileInputStream serviceAccount = 
                new FileInputStream("C:/credenciales-firebase/servicio-veterinaria-firebase-adminsdk.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
            
            // Inicializa Firebase solo una vez
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            
            firestore = FirestoreClient.getFirestore();
            System.out.println("Conexión a Firebase establecida correctamente");
            
        } catch (IOException e) {
            System.err.println("Error al conectar con Firebase: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Firestore getFirestore() {
        return firestore;
    }
}
