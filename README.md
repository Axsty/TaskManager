Task Manager

Ett REST‑API för att hantera uppgifter i en task 
manager‑applikation. API:et låter dig skapa, hämta, uppdatera och radera
sysslor. Projektet är utvecklat som ett portfolioarbete inför min 
LIA‑ansökan och som en övning i det vi lärt oss i skolan.

🚀 Backend

    Java

    Maven

    Spring Boot

    Spring Web

    Spring Data JPA

    Lombok

🎨 Frontend (AI)

    JavaScript
    
    CSS

    HTML


🗄️ Databas

```
PostgreSQL (hostad via Neon)
```

🧱 Projektstruktur

Controller	-
Tar emot HTTP‑anrop och returnerar API‑svar.

Service	-
Affärslogik och validering.

Repository -
Databasinteraktion via JPA.

Model -
Entity‑klass för uppgifter.

Enum -
Statusvärden för uppgifter.

📡 API‑endpoints

```
POST /tasks – Skapa en ny task

GET /tasks – Hämta alla tasks

GET /tasks/{id} – Hämta en specifik task

PUT /tasks/{id} – Uppdatera en task

DELETE /tasks/{id} – Radera en task
```

⚠️ Felhantering

API:et använder en egen exception för att hantera fall där en task inte hittas.
Vid fel returneras ett tydligt felmeddelande med information om vad som gick fel.

👤 Om mig

Jag är student som nyligen hittat in i IT‑världen och 
fastnat för backend‑utveckling. Jag tycker det är fascinerande att bygga logiken 
som driver applikationer och att förstå hur allt hänger ihop bakom kulisserna.

📬 Kontakt

E‑post: [axel.staaffriborg@iths.se](mailto:axel.staaffriborg@iths.se)

LinkedIn: [www.linkedin.com/in/axel-staaf-friborg](http://www.linkedin.com/in/axel-staaf-friborg)
