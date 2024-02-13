JAVA 17
MAVEN 3.8 and > above


# Remove the file from the repository
git rm -r --cached .idea/

# now update your gitignore file to ignore this folder
echo '.idea' >> .gitignore