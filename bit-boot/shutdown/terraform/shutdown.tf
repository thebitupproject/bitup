#Security group cannot be created here. It has to be specific to the user at runtime

resource "aws_s3_bucket_object" "jar_upload" {
  acl = "public-read-write"
  bucket = "${var.lambda_bucket}"
  key = "shutdown.jar"
  source = "${var.lambda_code_path}"
}

resource "aws_lambda_function" "boot" {
  s3_bucket = "${aws_s3_bucket_object.jar_upload.bucket}"
  s3_key = "${aws_s3_bucket_object.jar_upload.key}"
  function_name = "shutdown"
  role = "arn:aws:iam::049531089867:role/bitup_boot_ec2"
  handler = "io.bit.up.handler.BitShutdown"
  runtime = "java8"
  timeout = 180
  memory_size = 512
}