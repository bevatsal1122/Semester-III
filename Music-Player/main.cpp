// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

#include<bits/stdc++.h>
#include<string.h>
#include<windows.h>
#include<unistd.h>

using namespace std;

struct node {
   struct node* prev;
   int songID;
   string songName;
   string songAuthor;
   string playlists;
   bool liked;
   int songDuration; // Song duration in Seconds
   struct node* next;
};

void pushtoCDLL(struct node **start, struct node **end, int songID, string songName, string songAuthor, int songDuration) {
   struct node *insertNode=(struct node *)malloc(sizeof(struct node));
   insertNode->songID=songID;
   insertNode->songName=songName;
   insertNode->songAuthor=songAuthor;
   insertNode->liked=false;
   insertNode->songDuration=songDuration;
   struct node *q=*start;
   if (q==NULL) {
      *start=insertNode;
      insertNode->prev=insertNode;
      insertNode->next=insertNode;
   }
   else {
      q=*end;
      insertNode->prev=q;
      q->next=insertNode;
      insertNode->next=*start;
   }
   *end=insertNode;
}

void deleteAtStart(struct node **start, struct node **end) {
   struct node *q=*start;
   cout<<"\nDeleted Song ID: "<<q->songID<<"\nDeleted Song Name: "<<q->songName<<"\n";
   if (q==*end) {
      *start=NULL;
      *end=NULL;
   }
   else {
      (q->next)->prev=*end;
      (*end)->next=q->next;
      *start=q->next;
   }
   free(q);
}

void deleteAtEnd(struct node **start, struct node **end) {
   struct node *q=*end;
   cout<<"\nDeleted Song ID: "<<q->songID<<"\nDeleted Song Name: "<<q->songName<<"\n";
   if (q==*start) {
      *start=NULL;
      *end=NULL;
   }
   else {
      (q->prev)->next=*start;
      (*start)->prev=q->prev;
      *end=q->prev;
   }
   free(q);
}

string parsetoLength(string str, int length) {
   if (str.length()>=length) return str.substr(0, length);
   for (int i=str.length(); i<=length; ++i) {
      str+=" ";
   }
   return str;
}

void showSongsLists(struct node *start, struct node *end) {
   cout<<"\n\nSong ID       Song Name \t\t  Author Name\t   Liked     Duration\n--------------------------------------------------------------------------------\n";
   if (start==end && start!=NULL) {
      cout<<"   "<<start->songID<<"   \t   "<<start->songName<<" \t "<<start->songAuthor<<"\t    "<<(start->liked ? "Yes\t        " : "No\t        ")<<start->songDuration<<"s\n"; 
   }
   else if (start!=NULL) {
      while (start!=NULL && start!=end) {
         cout<<"   "<<start->songID<<"   \t   "<<start->songName<<" \t "<<start->songAuthor<<"\t    "<<(start->liked ? "Yes\t       " : "No\t       ")<<start->songDuration<<"s\n"; 
         start=start->next;
      }
      cout<<"   "<<start->songID<<"   \t   "<<start->songName<<" \t "<<start->songAuthor<<"\t    "<<(start->liked ? "Yes\t       " : "No\t       ")<<start->songDuration<<"s\n";   
   }
   printf("\n");
}

bool songExists (struct node *start, struct node *end, int songID) {
   struct node *first=start;
   while (start!=NULL && start->songID!=songID) {
      start=start->next;
      if (start==first) return false;
   }
   return true;
}

string giveSongName(struct node *start, struct node *end, int songID) {
   struct node *first=start;
   while (start!=NULL && start->songID!=songID) {
      start=start->next;
      if (start==first) return "";
   }
   return (start->songName);
}

string toUpper(string str) {
   for (int i=0; i<str.length(); ++i) str[i]=toupper(str[i]);
   return str;
}

int main()
{
   struct node *top=NULL;
   struct node *last=NULL;
   bool autoplay=true;
   int nPlay=-1;
   map<int, map<string, vector<int>>> playlists;
   int length=3, choice;

   pushtoCDLL(&top, &last, 1, "Mai Hu Giyaan            ", "Takeshi Minamo", 180);
   pushtoCDLL(&top, &last, 2, "Zindagi Savar Du         ", "Doremon       ", 210);
   pushtoCDLL(&top, &last, 3, "Maan meri jaan           ", "King          ", 225);
   showSongsLists(top, last);

   printf("\nOptions-\n1. Add Song \n2. Play a Song\n3. List all Songs\n4. List all Playlists\n5. Create a Playlist\n6. Enter into a Playlist\n7. Remove Song\n8. Like a Song\n9. Exit\n\nChoice: ");
   cin>>choice;

   while (choice!=9) {
      if (choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6 && choice!=7 && choice!=8) printf("\nWrong Option Entered!!\n");

      else if (choice==1) {
         length++;
         string songName, songAuthor;
         int songDuration;
         cin.ignore(numeric_limits<streamsize>::max(),'\n');
         cout<<"Enter Song Name: "; getline(cin, songName);
         songName=parsetoLength(songName, 21);
         cout<<"Enter Song Author: "; getline(cin, songAuthor);
         songAuthor=parsetoLength(songAuthor, 14);
         cout<<"Enter Song Duration (In Seconds): "; cin>>songDuration;
         pushtoCDLL(&top, &last, length, songName, songAuthor, songDuration);
         showSongsLists(top, last);
      }

      else if (choice==2) {
         int songID, key=1;
         cout<<"Enter Song ID: "; cin>>songID;
         struct node *q=top;
         while (q!=NULL && q->songID!=songID) {
            q=q->next;
            if (q==top) {key=0; break;}
         }
         if (!key) cout<<"\nSong with ID "<<songID<<" do not exist. Please recheck and try again.\n";
         else {
            int playNext=1;
            while (playNext) {
               int time=0;
               cout<<"\nPlaying "<<q->songName<<"...\nFrom "<<q->songAuthor<<"\n"<<(q->liked ? "Liked" : "Not liked")<<"\n\n";
               cout<<"0m 0s\t";
               while (time<=q->songDuration) {
                  time+=10;
                  sleep(2);
                  cout<<"\t"<<time/60<<"m "<<time%60<<"s\t";
               }
               cout<<"\n\nPlay Next ?? (1 for Yes, 0 for No)\nChoice - "; cin>>playNext;
               if (playNext) q=q->next;
            }
         }
      }
      
      else if(choice==3) showSongsLists(top, last);

      else if (choice==4) {
         map<int, map<string, vector<int>>>::iterator itr;
         map<string, vector<int>>::iterator ptr;
         cout<<"\nPlaylist ID\tPlaylist Name\t No. of Songs\n---------------------------------------------------------\n";
         for (itr = playlists.begin(); itr != playlists.end(); itr++) {
            for (ptr=itr->second.begin(); ptr!=itr->second.end(); ptr++) {
                  cout <<"     "<<(itr->first+1)<<"   \t  "<<ptr->first<<"\t"<<(ptr->second).size()<<"\n";
            }
         }
      }

      else if (choice==5) {
         nPlay++;
         string playName;
         cin.ignore(numeric_limits<streamsize>::max(),'\n');
         cout<<"Create Playlist Name: "; getline(cin, playName);
         playName=parsetoLength(playName, 14);
         vector<int> selection;
         int addMore=1;
         cout<<"\nAdd Song/s to Playlist "<<playName<<"\n";

         while (addMore) {
            int sID;
            cout<<"Enter Song ID: "; cin>>sID;
            vector<int>::iterator it=find(selection.begin(), selection.end(), sID);
            if (it!=selection.end()) cout<<"\nSong already exists...\n";
            else {
               if (songExists(top, last, sID)) selection.push_back(sID);
               else cout<<"\nSong with ID "<<sID<<" do not exist.\n";
            }
            cout<<"\nAdd more Songs ?? (1 for Yes, 0 for No)\nChoice - ";
            cin>>addMore;
         }
         playlists[nPlay].insert(pair<string, vector<int>>(playName, selection));
         cout<<"\nPlaylist Created, "<<playName<<"\n";
      }

      else if (choice==6) {
         string playName;
         bool key=true;
         cin.ignore(numeric_limits<streamsize>::max(),'\n');
         cout<<"Enter Playlist Name: "; getline(cin, playName);
         map<int, map<string, vector<int>>>::iterator itr;
         map<string, vector<int>>::iterator ptr;
         
         for (itr = playlists.begin(); itr!=playlists.end() && key; itr++) {
            for (ptr=itr->second.begin(); ptr!=itr->second.end() && key; ptr++) {
               string target=toUpper(ptr->first);
               playName=toUpper(playName);
               if (target.find(playName)!=string::npos) {
                  cout<<"\nEntered into Playlist, "<<ptr->first<<"\nPlaylist ID: "<<(itr->first+1)<<"\n";
                  cout<<"\nSong ID\tSong Name\n----------------------\n";
                  for (unsigned int i=0; i<(ptr->second).size(); ++i) cout<<(ptr->second)[i]<<"\t"<<giveSongName(top, last, (ptr->second)[i])<<"\n";
                  key=false;
                  int songID, flag=1;
                  while (true) {
                     cout<<"\nEnter Song ID or 0 to Exit: ";
                     cin>>songID;
                     if (!songID) break;
                     vector<int>::iterator it=find((ptr->second).begin(), (ptr->second).end(), songID);
                     if (it==(ptr->second).end()) {
                        cout<<"\nSong doesn't exist in the Playlist...\n";
                        continue;
                     }

                     struct node *q=top;
                     while (q!=NULL && q->songID!=songID) {
                        q=q->next;
                        if (q==top) {flag=0; break;}
                     }
                     int playNext=1;
                     while (playNext && flag) {
                        int time=0;
                        cout<<"\nPlaying "<<q->songName<<"\nFrom "<<q->songAuthor<<"\n"<<(q->liked ? "Liked" : "Not liked")<<"\n\n";
                        cout<<"0m 0s\t";
                        while (time<=q->songDuration) {
                           time+=10;
                           sleep(2);
                           cout<<"\t"<<time/60<<"m "<<time%60<<"s\t";
                        }
                        cout<<"\n\nPlay Next ?? (1 for Yes, 0 for No)\nChoice - "; cin>>playNext;
                        if (playNext) q=q->next;
                     }
                     if (!flag) cout<<"\nSong not found...\n";
                  }
               }
               else cout<<"\nPlaylist doesn't exist...\n";
            }
         }
      }

      else if (choice==7) {
         int songID, key=1;
         showSongsLists(top, last);
         cout<<"\nEnter Song ID: "; cin>>songID;
         struct node *q=top;
         while (q!=NULL && q->songID!=songID) {
            q=q->next;
            if (q==top) {key=0; break;}
         }
         if (!key) cout<<"\nSong with ID "<<songID<<" do not exist.\n";
         else {
            map<int, map<string, vector<int>>>::iterator itr;
            for (itr=playlists.begin(); itr!=playlists.end(); itr++) {
               vector<int>::iterator ptr = (itr->second).begin()->second.begin();
               vector<int>::iterator ptr1 = (itr->second).begin()->second.end();
               if (find(ptr, ptr1, songID)!=ptr1) (((itr->second).begin())->second).erase(find(ptr, ptr1, songID));
            }
            if (q==top && q==last) top=last=NULL;
            else if (q==top) deleteAtStart(&top, &last);
            else if (q==last) deleteAtEnd(&top, &last);
            else {
               cout<<"\nDeleted Song ID: "<<q->songID<<"\nDeleted Song Name: "<<q->songName<<"\n";
               struct node *r=q->prev;
               r->next=q->next;
               q->next->prev=q->prev;
               free(q);
            }
            showSongsLists(top, last);
         }
      }

      else if (choice==8) {
         int songID, key=1;
         showSongsLists(top, last);
         cout<<"\nEnter Song ID: "; cin>>songID;
         if (!songExists(top, last, songID)) cout<<"\nSong with ID "<<songID<<" do not exist.\n";
         else {
            struct node *q=top;
            while (q!=NULL && q->songID!=songID) {
               q=q->next;
               if (q==top) break;
            }
            if (q->liked) {
               int choice;
               cout<<"Song already liked. Dislike it ?? (1 for Yes, 0 for No)\nChoice - ";
               cin>>choice;
               if (choice) q->liked=false;
            }
            else {
               q->liked=true;
               cout<<q->songName<<"\nSong liked...\n";
            }
         }
      }
      
      printf("\nOptions-\n1. Add Song \n2. Play a Song\n3. List all Songs\n4. List all Playlists\n5. Create a Playlist\n6. Enter into a Playlist\n7. Remove Song\n8. Like a Song\n9. Exit\n\nChoice: ");
      cin>>choice;
   }

   if (top==last & top!=NULL) free(top);
   else {
      while (top!=last) {
         struct node* q=top;
         top=top->next;
         free(q);
      }
   }
   printf("\nExiting...\n");

   return 0;
}
