#!/bin/bash
echo 'strating server...'
bin/./HarearsWarriorsServer || (echo 'server crash...' && sleep 3 && ./run.sh)
exit 0