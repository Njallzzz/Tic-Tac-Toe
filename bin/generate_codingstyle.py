#!/usr/bin/python3.5
from pprint import pprint

projectdir = '/home/tester/Tic-Tac-Toe'
webpath = '/www'

with open('{project}/bin/ref_codingstyle.html'.format(project=projectdir), encoding='UTF-8') as cf:
	page = cf.read();

with open('{project}/documentation/CodingStyle.md'.format(project=projectdir), encoding='UTF-8') as rd:
	readme = rd.read();

page = page.format(CONTENT=readme)

with open('{web}/codingstyle.html'.format(web=webpath), 'w', encoding='UTF-8') as output:
	output.write(page)


with open('{project}/bin/ref_workflow.html'.format(project=projectdir), encoding='UTF-8') as cf:
        page = cf.read();

with open('{project}/documentation/workflow.md'.format(project=projectdir), encoding='UTF-8') as rd:
        readme = rd.read();

page = page.format(CONTENT=readme)

with open('{web}/workflow.html'.format(web=webpath), 'w', encoding='UTF-8') as output:
        output.write(page)
