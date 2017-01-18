provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region     = "${var.region}"
}

# Security group cannot be created here. It has to be specific to the user at runtime

resource "aws_s3_bucket" "lambda_bucket" {
  bucket = "bitup-functions"
  acl = "public-read-write"
  force_destroy = true
}

resource "aws_s3_bucket_object" "jar_upload" {
  acl = "public-read-write"
  bucket = "${aws_s3_bucket.lambda_bucket.id}"
  key = "boot.jar"
  source = "../target/up-0.0.1-SNAPSHOT.jar"
  etag = "${md5(file("../target/up-0.0.1-SNAPSHOT.jar"))}"
}

resource "aws_lambda_function" "boot" {
  s3_bucket = "${aws_s3_bucket_object.jar_upload.bucket}"
  s3_key = "${aws_s3_bucket_object.jar_upload.key}"
  function_name = "boot-ec2"
  role = "arn:aws:iam::049531089867:role/bitup_boot_ec2"
  handler = "io.bit.up.handler.BitUp"
  runtime = "java8"
  timeout = 180
  memory_size = 512
}