.bss
.globl nomor
.size  nomor, 4
nomor:
.zero 4
.globl nomorkalidua
.size  nomorkalidua, 4
nomorkalidua:
.zero 4
.section	.rodata
.print_str_format:
.string	"%s\n"
.print_int_format:
.string	"%d\n"
.scan_int_format:
.string	"%d"
.text
.globl main
.type	main, @function
main:
push   $._str_1
push   $.print_str_format
call   printf
popl   %ebx
popl   %ebx
pushl   $nomor
push   $.scan_int_format
call   scanf
popl   %ebx
popl   %ebx
movl   nomor, %eax
pushl  %eax
pushl   $2
popl   %eax
popl   %ebx
imull   %ebx, %eax
pushl   %eax
popl %eax
movl %eax, nomorkalidua
push   $._str_2
push   $.print_str_format
call   printf
popl   %ebx
popl   %ebx
push   nomor
push   $.print_int_format
call   printf
popl   %ebx
popl   %ebx
push   $._str_3
push   $.print_str_format
call   printf
popl   %ebx
popl   %ebx
push   nomorkalidua
push   $.print_int_format
call   printf
popl   %ebx
popl   %ebx
push   $._str_4
push   $.print_str_format
call   printf
popl   %ebx
popl   %ebx
ret
.size	main, .-main
.section	.rodata
._str_1:
.string "input nomor:"
._str_2:
.string "nomor adalah "
._str_3:
.string "nomor kali dua adalah "
._str_4:
.string "tes kedua"

