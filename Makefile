
run: out/BonesBot.class
	java -cp out/ BonesBot

out/BonesBot.class: src/BonesBot.java out/*.class
	javac -cp src/ -d out/ src/BonesBot.java

out/BonesBotBase.class: src/BonesBotBase.java
	javac -cp src/ -d out/ src/BonesBotBase.java

out/BotChat.class: src/BotChat.java
	javac -cp src/ -d out/ src/BotChat.java

out/CheckButton.class: src/CheckButton.java
	javac -cp src/ -d out/ src/CheckButton.java

out/ContinueButton.class: src/ContinueButton.java
	javac -cp src/ -d out/ src/ContinueButton.java

out/GuessEntry.class: src/GuessEntry.java
	javac -cp src/ -d out/ src/GuessEntry.java

out/HintButton.class: src/HintButton.java
	javac -cp src/ -d out/ src/HintButton.java

out/Item.class: src/Item.java
	javac -cp src/ -d out/ src/Item.java

out/ItemDisplay.class: src/ItemDisplay.java
	javac -cp src/ -d out/ src/ItemDisplay.java

out/Sidebar.class: src/Sidebar.java
	javac -cp src/ -d out/ src/Sidebar.java

out/SkipButton.class: src/SkipButton.java
	javac -cp src/ -d out/ src/SkipButton.java

