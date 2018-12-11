# SpringBootHashiCorpVaultDemo
Spring Boot Microservices Application with Hashicorp Vault and consul integration to secure DB and generate dynamic credentials for end user.

Steps to start the project
--------------------------

Prerequiste
-----------

i. Database used in this demo is PostgreSQL so it should be installed and configured.
ii. Hashicorp Consul
iii. Hashicorp Vault.


1. Start Consul
================================================================================

	a. Start the consul with below given command
		consul agent -dev
		
		this will start consul in dev mode and we can see all the services registered to consul on loacalhost:8500

================================================================================

2. Start Hashicorp Vault
================================================================================

	a. Start vault server by using below given command in dev mode with root access
		vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"

		It will start vault server.
	
	b. Put the vault server address(host and ip) which by default is http://127.0.0.1:8200 on the systems path so that
		vault clients can use it to connect to vault server.
		
	c. Put the vault token also on systems path.
	
	d. Configure Vault for Database either running commands on cmd or in vault's ui on http://127.0.0.1:8200 .
	
	e. Enable database secretes on vault using below given command
		vault secrets enable database
		Will get a message "Success! Enabled the database secrets engine at: database/" if enabled successfully.
		
	f. Configure database details like DB role, connection-url, username and password by below given command
		vault write database/config/postgresql plugin_name=postgresql-database-plugin allowed_roles="manager" \
		connection_url="postgresql://{{username}}:{{password}}@localhost:5432/employeemanagement?sslmode=disable" \ 
		username="postgres" password="postgres"
		
	g. Create and configure DB for dyanmic credentials from Vault using below given command
		vault write database/roles/manager db_name=postgresql \ 
		creation_statements="CREATE ROLE "'"{{name}}"'" WITH SUPERUSER LOGIN PASSWORD '{{password}}' VALID UNTIL '{{expiration}}';" \ 
		revocation_sql="SELECT revoke_access('{{name}}'); DROP user "'"{{name}}"'";" default_ttl="1h" max_ttl="24h"
		
	h. We can read the dynamically created credentials by below given command
		vault read database/creds/manager
		
	Vault is now configured to generate and provide dynamic credentials to connect to DB at any time.
	
================================================================================
3. Start EmployeeManagement Application

================================================================================

	a. Run "gradle bootRun" in the root of project
	   The application will start running and register itself on consul.
	   It will connect to DB by getting credentials from vault.
	   
	b. To check if it's connected to DB we can use swagger here by hitting http://localhost:9094/swagger-ui.html url.
		We can do a post queary initially as there will be no data initially in the DB using Swagger UI.
		

	EmployeeManagement Application should be connected to DB and should work fine now.
	
================================================================================

4. Start EmployeeDashboard Application

================================================================================

	a.  Run "gradle bootRun" in the root of project
		The application will satart and will register itself on consul and after that will also discover the EmployeeManagement service.
		
	b. To check if it has discovered EmployeeManagement service we can again use SwaggerUI by hitting http://localhost:9095/swagger-ui.html url.
		As of now only one API is implemented to get list of all the employees from EmployeeManagement service.
		Doing a get request should bring the list of all employees stored in DB using EmployeeManagement service.
		
================================================================================