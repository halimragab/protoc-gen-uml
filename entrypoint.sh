#!/bin/bash

protoc --uml_out=/uml_output -I/protos /protos/*.proto
