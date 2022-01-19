#/usr/bin/perl
use strict;


open (IN, "asap_test_public_translated.txt") or die "Can't open infile";
while (my $line = <IN>){
    if ($line =~/^(\d+) (\d+) (\d) (\d) (.*)$/){
	print $5."\n";
    } else {
print "Strange line $line";
    }
}
