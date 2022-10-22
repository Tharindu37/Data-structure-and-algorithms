#include <stdio.h>
#include <string.h>

int main() {
	char S[100];
	int i, j, k;

	printf("Enter any String(Don't use uppercase letters) :");
	scanf("%s", S);
	//check for uppercase letters
	for(i = 0; S[i] != 0; i++) {
	    if(S[i] >= 'A' && S[i] <= 'Z') {
            printf("Check whether there are any uppercase letters.\n");
            return -1;
	    }

	}

  //check and remove duplicate characters
	for(i = 0; i < strlen(S); i++) {
		for(j = i + 1; S[j] != '\0'; j++) {
			if(S[j] == S[i]) {
				for(k = j; S[k] != '\0'; k++) {
					S[k] = S[k + 1];
				}
			}
		}
	}

	printf("The final String after removing all duplicates = %s \n", S);

	return 0;
}

