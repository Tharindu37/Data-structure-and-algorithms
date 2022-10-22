#include<stdio.h>
#include<string.h>

//Set the reverse order of the string
const char* getRevStr(char *str1) {
  int i, len, temp;
  len = strlen(str1);

  for (i = 0; i < len/2; i++)  {
    // temp variable use to temporary hold the string
    temp = str1[i];
    str1[i] = str1[len - i - 1];
    str1[len - i - 1] = temp;
  }

  return str1;
}


int main() {
  int i, j, N, temp;
  char str[100][14], str1[14];
  int minN = 1, maxN = 100;

  //Scan the user entries
  while (minN > N || N > maxN) {
    printf("Enter the number of possible passwords: ");
    scanf("%d", &N);
    //check the N
    if(N <= minN || N >= maxN) {
        //if N is not in the range
        printf("The range is not valid.\n");
        printf("Range needs to be between 1-100.\n");
        return -1;
    }
    printf("Enter possible Passwords\n");
    for( i = 0; i  <  N; i++) {
      scanf("%s", str[i]);

    }
  }

  for(i = 0; i < N; i++) {
    //assign str to str1
    strcpy(str1, str[i]);
    //get the length of the string
    int len = strlen(str[i]);
    //check for uppercase letters

    //check the length of the string
    if(len < 2 || len > 14) {
        //if the input is not in range
        printf("The length of the '%s' string is not in between 2-14\n", str[i]);
        return -1;
    }
    else {
            //check whether the length is odd
            if(len % 2 != 1) {
                printf("The length of the '%s' is not odd.\n", str[i]);
                return -1;
            }
    }
  }

  for(i = 0; i < N; i++) {
      int len = strlen(str[i]);
        for(j = 0; j < N; j++) {
            //compare the string with its reverse order
            if(strcmp(str[j], getRevStr(str1)) == 1) {
                len = strlen(str[i]);
                printf("%d %c\n", len, str[i][len / 2]);
                return 0;
            }
        }
  }

}


