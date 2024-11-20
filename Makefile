.PHONY: install

install:
	@echo "Installing..."
	@mvn clean install -DskipTests
package:
	@echo "Packaging..."
	@mvn clean package -DskipTests

