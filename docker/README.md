# Usage

1. Put `application.yml` to a local directory that can be mounted by docker.
2. Mount this folder to `/intersensorservice/config`.

```bash
docker run -d --name intersensorservice \
    -p 8080:8080 \
    -v d:/docker/intersensorservice:/intersensorservice/config \
  tumgis/intersensorservice
```

# How to build

```bash
docker build -t tumgis/intersensorservice .
```
