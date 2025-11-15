/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author GRUPO_PROG_2_C_1_ 4
 */
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
            //ruta de la llave de conexión con Firebase
            FileInputStream serviceAccount = 
                new FileInputStream("firebase-config/servicio-veterinaria-firebase-adminsdk.json");
            
            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
            
            //si existe
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            
            firestore = FirestoreClient.getFirestore();
            //Conexion a Firebase establecida correctamente
            System.out.println("");
            
        } catch (IOException e) {
            System.err.println("Error al conectar con Firebase: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Firestore getFirestore() {
        return firestore;
    }
}