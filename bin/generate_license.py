#!/usr/bin/python3.5
from pprint import pprint

projectdir = '/home/tester/Tic-Tac-Toe'
webpath = '/www'

with open('{project}/bin/ref_license.html'.format(project=projectdir), encoding='UTF-8') as cf:
	page = cf.read();

with open('{project}/LICENSE.md'.format(project=projectdir), encoding='UTF-8') as rd:
	readme = rd.read();

ipage = page.format(LICENSE=readme)

with open('{web}/license.html'.format(web=webpath), 'w', encoding='UTF-8') as output:
	output.write(page)
