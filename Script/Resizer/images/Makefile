# Makefile
# Marion Noirbent

TITLE=
MANIFEST=manifest
ENVIRONEMENT= classes src

CC=javac
CCRUN=java
CCDOC=javadoc

CCFLAGS=-d classes
TESTCFLAGS=-classpath test-1.7.jar $(TESTPATH)*.java  -d classes
TESTRUNFLAGS=$(RUNFLAGS) test-1.7.jar
DOCFLAGS=-d ../docs -charset "utf-8" -author
RUNFLAGS=-jar

OBJPATH= . $(TESTPATH)
SRCPATH= src/
TESTPAKAGE=test/$(MAJPACKAGE)Test
MAJPACKAGE=dungeon
MINPACKAGE=

# __________________________________________________

all: jar run

envdev:
	@echo " structure de l'environnement de travail";
	@$(foreach dir, $(ENVIRONEMENT), mkdir $(dir) ;)
	@mkdir $(TESTPATH);
	@$(foreach dir, $(MINPACKAGE), mkdir $(MAJPACKAGE)/$(dir) ;)
	@touch readme.txt $(MANIFEST) $(SRCPATH)$(MAJPACKAGE)Main.java
	@echo "Main-Class: "$(MAJPACKAGE).$(MAJPACKAGE)Main"\n" > $(MANIFEST);
	@git add .;

compilclasses:
	@echo " Compilation des sources";
# @$(CC) $(foreach dir, $(MINPACKAGE), $(SRCPATH)$(MAJPACKAGE)/$(dir)/*.java) $(CCFLAGS)
# make -C $(SRCPATH)

## Test
test:
	@echo " Compilation des tests";
	@$(CC) $(TESTCFLAGS);

	@echo " Lancement des tests";
	$(CCRUN) $(RUNFLAGS) ##NOM des test !


## Documentation
creerdoc:
	@echo " Création de la documentation";
	@cd src && $(CCDOC) #rental rental.criterion rental.vehicle# $(DOCFLAGS) 1> /dev/null

jar: emacsclean compilclasses test creerdoc
	@echo " Création du jar";
	@jar cvfm $(TITLE).jar $(MANIFEST) docs test -C classes $(MAJPACKAGE) 1> /dev/null

#exécution par 'make args="val" run' si le jar exige des paramètres à l'exécution
run:
	@echo " Execution du jar";
	@$(CCRUN) $(RUNFLAGS) $(TITLE).jar ${args}

# __________________________________________________

.PHONY:envdev compilclasses jar test run emacsclean clean creerdoc

# Cleaner
emacsclean:
	@echo " Nettoyage des fichiers temporaires";
	@$(foreach dir, $(OBJPATH), rm -rf $(dir)/*~ ;)

clean: emacsclean
