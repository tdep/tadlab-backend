# TadLab Backend API
---
A Java based API that integrates with a PostgreSQL database serving as the basis for the [frontend TadLab client](https://github.com/tdep/tdep-tadlab-client).
To see the frontend client in action, [visit my portfolio here](https://www.trevordepew.com/portfolio).

### Tools used:
- Java
- Springboot
- JPA
- PostgreSQL
- Heroku

### Why build an API for a static portfolio website?
I wanted to use some of the principles I learned during my time as an Engineering Fellow at Spotify. There I learned about DAO, ORMs, separation of responsibility, gRPC, API structure, and Java. While this isn't an Enterprise level application, I did my best to structure the project in a way that could be expanded in the future.

### How was Java / Springboot / Postgres chosen?
Since the majority of my experience at Spotify was in Java, I wanted to make a practical application so I could continue to learn and develop the skills I had gained. I also found a love for Java and typed languages in general. Springboot seemed like a logical tool to use because of its ubiquity, though in the beginning I did try to build my project without using any of the Springboot annotations. After some time, I decided to alter the pattern from using a manually defined DAO and DTO structure to using the pattern of Entity and Repository described in Springboot's documentation along with the appropriate annotations. Postgres also seemed to be a widely available RDBMS and is nicely integratable within Heroku (where I was deploying this and the frontend).

### Future plans?
As I mentioned, I wanted this project to serve as the basis for a larger service, so I tried to set it up in a way that I could expand in the future. With that in mind, some of the things I'd like to do include but are not limited to:
- [ ]  Creating a `User Service` and authentication to allow for the creation of user and admin accounts.
- [ ]  Build a dashboard to serve as the method in which I can easily edit the data on the site without using the terminal or Postman (this is mostly frontend, but will integrate in the creation of an admin).
- [ ]  Expand into different modules and try building applications of interest (like software synthesizers!).
- [ ]  Streamline the data handling as I continue to learn about stuff (super specific, I know).
- [ ]  Introduce an RPC structure in favor of REST endpoints.
- [ ]  Create a runnable package (and just learn about this in general).

### Special thanks:
- @chaoms for reviewing and suggesting!
- @ashkan18 for helping me understand and being a great mentor/manager!

### To run locally:
I don't anticipate any need outside of myself to run this locally, but if you need to:
Run `TadlabApplication` as a Springboot application (I use IntelliJ IDEA).
You would need to connect a database and point the configuration to it for full functionality.
