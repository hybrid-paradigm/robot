from matplotlib import pyplot as plt

import numpy as np
import argparse

parser = argparse.ArgumentParser(description="Pass in required shares")
parser.add_argument("-f", "--file", dest="file", help='input file')
args = parser.parse_args()

#options, args = parser.parse_args()
print args.file

data=np.genfromtxt("%s" % args.file)
print data

y=data[:,2]
print y
x=data[:,0]
print x

plt.plot(x,y)

plt.title('Price Graph')
plt.ylabel('Price')
plt.xlabel('Day')

plt.savefig('%s.png' % (args.file))
#plt.show()