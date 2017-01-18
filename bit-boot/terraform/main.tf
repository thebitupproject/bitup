provider "aws" {
  access_key = "${var.access_key}"
  secret_key = "${var.secret_key}"
  region     = "${var.region}"
}

resource "aws_s3_bucket" "lambda_bucket" {
  bucket = "bitup-functions"
  acl = "public-read-write"
  force_destroy = true
}

module "up" {
  source = "../up/terraform"

  lambda_bucket = "${aws_s3_bucket.lambda_bucket.id}"
  lambda_code_path = "../up/target/up-0.0.1-SNAPSHOT.jar"
}

module "shutdown" {
  source = "../shutdown/terraform"

  lambda_bucket = "${aws_s3_bucket.lambda_bucket.id}"
  lambda_code_path = "../shutdown/target/shutdown-0.0.1-SNAPSHOT.jar"
}