<p align="center"><h1 align="center">Jwt Authentication and Session management</h1></p>

<p align="center">
	<!-- Shields.io badges disabled, using skill icons. --></p>
<p align="center">Built with the tools and technologies:</p>
<p align="center">
	<a href="https://skillicons.dev">
		<img src="https://skillicons.dev/icons?i=java,spring,supabase,maven&theme=dark">
	</a></p>
<br>

##  How does it work?

<p>Only upon successful login, a JWT token is generated and cannot b bypassed coz all the claims used to build the token are harvested from the authentication object which will b null in case authentication fails.
While validating, the token is parsed for claims and looked up from the databse to check validity. all thanks to hash coding the credentials, it cant b bypassed. it also has CSRF safety, the session Id check is hidden nd handled internally by Spring coz Ive tried sending a token not generated from my session.</p>


##  Features
<ol>
<li>Less Payload size since user sends only the token as header</li>
<li>CSRF Safety by Jwt based Auth</li>
<li>Session Hijack Safety</li>
<li>Persistant Sessions</li>
</ol>


##  Getting Started

###  Prerequisites

Before getting started with SpringSecurityAuthTemplate, ensure your runtime environment meets the following requirements:

- **Programming Language:** Java


###  Installation

Install SpringSecurityAuthTemplate using one of the following methods:

**Build from source:**

1. Clone the SpringSecurityAuthTemplate repository:
```sh
❯ git clone https://github.com/Devang-sharma609/SpringSecurityAuthTemplate
```

2. Navigate to the project directory:
```sh
❯ cd SpringSecurityAuthTemplate
```

###  Usage
Run Application File with the @SpringBootApplication annotation
Use Postman for API Requests
