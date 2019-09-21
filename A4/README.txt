Aim: The program should take 2 outputs ip address and subnet mask and output the network number and every 10th usable ip address starting from first usable ip address
concept: The subnet mask determines the network number of address. the network number is obtained by performing bitwise AND operation between subnet mask and ip address.
programming example: consider the ip address and subnet mask =192.168.136.100/22
                     It splits the subnet from ip address,
                     then the ip is divided into four parts and each part has the capacity to hold 8 bits of data.   
                     we call the binary function for each divided value in ip.
                     it converts each part into binary.
                     main function consists of two arrays, Network and Usable. i.e N- network and B- broadcast.
                     This is necessary because any usuable ip exists between network and broadcast address.
                     For loops are used and the binary array is being copied to network and usable.
                     two more loops for network and broadcast address we call for decimal function
                     its then printed and 10th usable ip address is obtained by the last network+10.
sources: ppts.

NOTE: Please change the directory to A4 and then src before executing the java file.


                      