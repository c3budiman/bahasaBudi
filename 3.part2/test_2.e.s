.section	.rodata
.mytext:
.string	"Result %d\n"
.text
.globl main
.type	main, @function
main:
pushl   $1
pushl   $3
popl   %eax
popl   %ebx
addl   %ebx, %eax
pushl   %eax
push   $.mytext
call   printf
popl   %ebx
popl   %ebx
pushl   $2
pushl   $2
popl   %eax
popl   %ebx
imull   %ebx, %eax
pushl   %eax
push   $.mytext
call   printf
popl   %ebx
popl   %ebx
pushl   $2
pushl   $3
pushl   $4
popl   %eax
popl   %ebx
imull   %ebx, %eax
pushl   %eax
popl   %eax
popl   %ebx
addl   %ebx, %eax
pushl   %eax
push   $.mytext
call   printf
popl   %ebx
popl   %ebx
pushl   $20
push   $.mytext
call   printf
popl   %ebx
popl   %ebx
pushl   $2
pushl   $5
pushl   $6
popl   %eax
popl   %ebx
addl   %ebx, %eax
pushl   %eax
popl   %eax
popl   %ebx
imull   %ebx, %eax
pushl   %eax
push   $.mytext
call   printf
popl   %ebx
popl   %ebx
pushl   $10
pushl   $2
pushl   $3
popl   %eax
popl   %ebx
imull   %ebx, %eax
pushl   %eax
popl   %eax
popl   %ebx
subl   %eax, %ebx
pushl   %eax
push   $.mytext
call   printf
popl   %ebx
popl   %ebx
ret
.size	main, .-main

