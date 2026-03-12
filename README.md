# 🚀 User Management API

Ένα γρήγορο, καθαρό και επεκτάσιμο RESTful API φτιαγμένο με **Spring Boot** για τη διαχείριση χρηστών και των διευθύνσεών τους. Το project χρησιμοποιεί αρχιτεκτονική βασισμένη σε DTOs, διαθέτει custom exception handling και η βάση δεδομένων (MySQL) είναι στημένη σε Docker.

---

## 🛠️ Tech Stack

* **Γλώσσα:** Java 25
* **Framework:** Spring Boot 4.0.3
* **Βάση Δεδομένων:** MySQL (Dockerized)
* **ORM:** Spring Data JPA / Hibernate
* **Build Tool:** Maven
* **Άλλα Εργαλεία:** Lombok 

---

## ✨ Βασικά Χαρακτηριστικά (Features)

* **Πλήρες CRUD:** Λειτουργίες δημιουργίας, ανάγνωσης, ενημέρωσης και διαγραφής χρηστών.
* **Σχέσεις Βάσης:** `One-To-Many` σχέση ανάμεσα σε Χρήστες και τις Διευθύνσεις τους (Home, Work κτλ.).
* **Έξυπνο Mapping:** Χρήση custom Mapper για την ασφαλή μετατροπή των Entities σε DTOs και το αντίστροφο.
* **Validation & Business Logic:** Αποτροπή δημιουργίας χρηστών με το ίδιο ακριβώς Ονοματεπώνυμο.
* **Global Exception Handling:** Κεντρική διαχείριση σφαλμάτων (`@RestControllerAdvice`) που επιστρέφει καθαρά JSON μηνύματα στον client (π.χ. 404 Not Found, 409 Conflict).

---

## ⚙️ Εγκατάσταση & Εκτέλεση (Setup)

### 1. Προαπαιτούμενα
Βεβαιώσου ότι έχεις εγκατεστημένα στο μηχάνημά σου:
* Java (JDK 25)
* Maven
* Docker (για τη βάση δεδομένων)

### 2. Στήσιμο Βάσης Δεδομένων (Docker)
Εφόσον η βάση τρέχει σε Docker, σήκωσε γρήγορα ένα MySQL container με τις σωστές ρυθμίσεις τρέχοντας την παρακάτω εντολή στο terminal:

```bash
docker run --name usermanagement-mysql -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=user_management -p 3306:3306 -d mysql:latest
```

### 3. Build & Τρέξιμο του Project
Αφού σηκωθεί η βάση, κατέβασε το project στον υπολογιστή σου και τρέξε το μέσω Maven:

```bash
mvn clean install
mvn spring-boot:run
```
🎉 Το API θα είναι πλέον διαθέσιμο στο: `http://localhost:8080/api/users`

---

## 📡 API Endpoints

| HTTP Method | Endpoint | Περιγραφή |
| :--- | :--- | :--- |
| `GET` | `/api/users` | Επιστρέφει λίστα με όλους τους χρήστες. |
| `GET` | `/api/users/{id}` | Επιστρέφει τα στοιχεία ενός συγκεκριμένου χρήστη. |
| `POST` | `/api/users` | Δημιουργεί έναν νέο χρήστη. |
| `PUT` | `/api/users/{id}` | Κάνει update τα στοιχεία ενός υπάρχοντος χρήστη. |
| `DELETE` | `/api/users/{id}` | Διαγράφει έναν χρήστη (μαζί με τις διευθύνσεις του). |

---

## 📝 Παράδειγμα JSON Request

Για να δημιουργήσεις έναν νέο χρήστη (`POST /api/users`), στείλε το παρακάτω JSON body:

```json
{
  "name": "Γιάννης",
  "surname": "Παπαδόπουλος",
  "gender": "M",
  "birthdate": "1990-05-15",
  "addresses": [
    {
      "type": "Home",
      "details": "Αριστοτέλους 10, Αθήνα"
    },
    {
      "type": "Work",
      "details": "Ερμού 25, Αθήνα"
    }
  ]
}
```

---

## 👨‍💻 Δημιουργός
Αναπτύχθηκε από τον **[Γιάννης]**.
